(ns decomplecting.main
  (:require [replicant.dom :as r]
            [datascript.core :as ds]
            [nexus.registry :as nxr]
            [dataspex.core :as dataspex]
            [decomplecting.effects]
            [decomplecting.actions]))

(defn render [db]
  (let [app    (ds/entity db :system/app)
        clicks (:clicks app)]
    [:div
     [:h1 "Hello world"]
     [:p "Started at " (:app/started-at app)]
     [:button
      {:on {:click [[:counter/inc app]]}}
      "Click me"]
     (when (< 0 clicks)
       [:p
        "Button was clicked "
        clicks
        (if (= 1 clicks) " time" " times")])]))

(nxr/register-system->state! ds/db)

(defn main [conn el]
  (r/set-dispatch!
   (fn [dispatch-data actions]
     (nxr/dispatch conn dispatch-data actions)))
  
  (add-watch
   conn ::render
   (fn [_ _ _ _]
     (r/render el (render (ds/db conn)))))

  (dataspex/inspect "DB" conn)
  
  ;; Trigger the initial render
  (ds/transact! conn [{:db/ident       :system/app
                       :app/started-at (js/Date.)}]))

(def schema {})
(defonce conn (ds/create-conn schema))
(defonce el (js/document.getElementById "app"))

(defn init []
  (main conn el))

(comment
  (ds/transact! conn [{:db/ident       :system/app
                       :app/started-at (js/Date.)}])

  )
