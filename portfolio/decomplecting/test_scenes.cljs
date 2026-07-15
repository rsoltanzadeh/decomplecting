(ns decomplecting.test-scenes
  (:require [portfolio.replicant :refer-macros [defscene]]
            [decomplecting.render :refer [test-paragraph]]))

(defscene test-scene
  "Test docstring for the `test-paragraph` render function."
  :params "Test"
  test-paragraph)

(comment
  (let [store (atom {})]
    (swap! @store :idx 0))
  )
