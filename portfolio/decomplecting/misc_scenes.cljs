(ns decomplecting.misc-scenes
  (:require [portfolio.replicant :refer-macros [defscene]]
            [decomplecting.render :as render]
            [phosphor.icons :as icons]))

(defscene hero
  :params {:title "Hero Title"
           :description "Hero description lorem ipsum."
           :button-label "Learn more."}
  render/hero)

(defscene list-view
  :params {:items [{:title "My First List"
                    :description "145 items"
                    :selectable? true
                    :actions {}}
                   {:title "My very long and cumbersome list"
                    :description "23333333333333333333333 items"
                    :actions {}}]}
  render/list-view)



