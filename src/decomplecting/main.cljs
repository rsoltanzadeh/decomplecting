(ns decomplecting.main
  (:require [replicant.dom :as r]
            [datascript.core :as ds]
            [nexus.registry :as nxr]
            [dataspex.core :as dataspex]
            [decomplecting.effects]
            [decomplecting.actions]
            [decomplecting.router :as router]))

(defn find-target-href [e]
  (some-> e .-target
          (.closest "a")
          (.getAttribute "href")))

(defn render-not-found [_ _]
  [:h1 "Not found"])

(defn render-frontpage [db location]
  (let [app    (ds/entity db :system/app)
        clicks (:clicks app)]
    [:div
     [:h1 (str "Hello " (:page-id location))]
     [:p "Started at " (:app/started-at app)]
     [:button
      {:on {:click [[:counter/inc app]]}}
      "Click me"]
     (when (< 0 clicks)
       [:p
        "Button was clicked "
        clicks
        (if (= 1 clicks) " time" " times")])]))

(defn render-test [_ _]
  [:h1 "Test"])

(defn render-page [db location]
  (let [f (case (:page-id location)
            :pages/frontpage render-frontpage
            :pages/test      render-test
            render-not-found)]
    (f db location)))

(nxr/register-system->state! ds/db)

(defn main [conn el]
  (r/set-dispatch!
   (fn [dispatch-data actions]
     (nxr/dispatch conn dispatch-data actions)))
  
  (add-watch
   conn ::render
   (fn [_ _ _ _]
     (r/render el
               (render-page (ds/db conn)
                            (router/path->location js/location.pathname)))))

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
