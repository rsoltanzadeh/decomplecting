(ns decomplecting.main
  (:require [replicant.dom :as r]
            [datascript.core :as ds]))

(def schema {}) ;; Empty for now

(defonce conn (ds/create-conn schema))

(defn render [db]
  (let [app (ds/entity db :system/app)]
    [:div
     [:h1 "Hello world"]
     [:p "Started at " (:app/started-at app)]]))

(defonce el (js/document.getElementById "app"))

(defn main [conn]
  (add-watch
   conn ::render
   (fn [_ _ _ _]
     (r/render el (render (ds/db conn)))))
  
  ;; Trigger the initial render
  (ds/transact! conn [{:db/ident       :system/app
                       :app/started-at (js/Date.)}]))

(defn init []
  (main conn))

(comment
  (ds/transact! conn [{:db/ident       :system/app
                       :app/started-at (js/Date.)}])
  )
