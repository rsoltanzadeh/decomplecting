(ns decomplecting.app
  (:require [replicant.dom :as r]))

(defn render [state]
  [:div
   [:h1 state]])

(defn init []
  (r/render js/document.body (render "Decomplecting.")))

(comment
  (r/render js/document.body (render "Testing."))

  (init))
