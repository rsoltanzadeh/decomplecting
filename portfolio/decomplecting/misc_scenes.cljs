(ns decomplecting.misc-scenes
  (:require [portfolio.replicant :refer-macros [defscene]]
            [decomplecting.render :as render]))

(defscene landing-hero
  render/landing-hero)

(defscene list-view
  :params {:items [{:title "My First List"
                    :description "145 items"
                    :selectable? true
                    :actions {}}
                   {:title "My very long and cumbersome list"
                    :description "23333333333333333333333 items"
                    :actions {}}]}
  render/list-view)

(defscene list-section
  :params {:items [{:title "My First List"
                    :description "145 items"
                    :selectable? true
                    :actions {}}
                   {:title "My very long and cumbersome list"
                    :description "23333333333333333333333 items"
                    :actions {}}]}
  [params portfolio-options]
  (render/section {:header [:button.btn "+ Add data source"]
                   :body  (render/list-view params)}))

