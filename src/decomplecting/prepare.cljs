(ns decomplecting.prepare
  (:require [datascript.core :as ds]))

(defn sources->list-view [{:keys [db]}]
  {:items [{:title       "My First List"
            :description "145 items"
            :selectable? true
            :actions     {:click (fn [e] (js/alert "foo"))}}
           {:title       "My very long and cumbersome list"
            :description "1337 items"
            :actions     {}}]})

