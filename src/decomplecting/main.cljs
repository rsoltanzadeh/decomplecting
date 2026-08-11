(ns decomplecting.main
  (:require [replicant.dom :as r]
            [datascript.core :as ds]
            [nexus.registry :as nxr]
            [dataspex.core :as dataspex]
            [decomplecting.effects]
            [decomplecting.actions]
            [decomplecting.router :as router]
            [decomplecting.pages :as pages]))

(defn find-target-href [e]
  (some-> e .-target
          (.closest "a")
          (.getAttribute "href")))

(defn render-page [db location]
  ((get pages/render-fns (:page-id location)) {:db db}))

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
