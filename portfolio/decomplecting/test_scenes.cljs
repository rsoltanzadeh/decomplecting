(ns decomplecting.test-scenes
  (:require [portfolio.replicant :refer-macros [defscene]]
            [decomplecting.render :as render]))

(defscene test-scene
  "Test docstring for the `test-paragraph` render function."
  :params "Test"
  render/test-paragraph)

(defscene test-scene2
  "Foobar"
  :params "Lorem ipsum"
  render/button)

(comment
  (let [store (atom {})]
    (swap! store assoc :idx 0))
  )
