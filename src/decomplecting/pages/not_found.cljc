(ns decomplecting.pages.not-found
  (:require [decomplecting.render :as render]
            [decomplecting.prepare :as prepare]))

(defn render-page [{:keys [db]}]
  [:h1 "Not found."])
