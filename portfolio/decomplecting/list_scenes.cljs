(ns decomplecting.list-scenes
  (:require [portfolio.replicant :refer-macros [defscene configure-scenes]]
            [decomplecting.render :as render]
            [phosphor.icons :as icons]))

(defscene list-view
  :params {:items [{:id "foo"
                    :title       "Lorem ipsum..."
                    :description "...dolor sit amet adipiscing elit."
                    :selected?   true
                    :options [{:icon (icons/icon :phosphor.regular/pencil)
                               :label "Edit"}]}
                   {:id "bar"
                    :title       "John Doe"
                    :description "23333333333333333333333 years old."
                    :options [{:icon (icons/icon :phosphor.regular/pencil)
                               :label "Edit"}]}]}
  render/list-view)
