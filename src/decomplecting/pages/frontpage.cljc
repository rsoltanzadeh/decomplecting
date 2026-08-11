(ns decomplecting.pages.frontpage
  (:require [decomplecting.render :as render]
            [decomplecting.prepare :as prepare]
            [datascript.core :as ds]))

(defn render-page [{:keys [db]}]
  (render/hero {:title "Decomplecting"
                :description "Simplicity is a choice."
                :button-label "->"}))
