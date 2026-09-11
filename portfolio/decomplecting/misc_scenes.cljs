(ns decomplecting.misc-scenes
  (:require [portfolio.replicant :refer-macros [defscene]]
            [decomplecting.render :as render]
            [phosphor.icons :as icons]))

(defscene hero
  :params {:title "Hero Title"
           :description "Hero description lorem ipsum."
           :button-label "Learn more."}
  render/hero)



