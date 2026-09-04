(ns decomplecting.dropdown-scenes
  (:require [portfolio.replicant :refer-macros [defscene configure-scenes]]
            [decomplecting.render :as render]
            [phosphor.icons :as icons]))

(defscene dropdown
  :params {:id "dropdown-1"
           :items [{:label "Option 1"}
                   {:label "Option 2"}]
           :trigger {:label "Test label"}}
  [params & _]
  [:div.h-36 (render/dropdown params)])

(defscene dropdown-bottom
  :params {:id "dropdown-1"
           :items [{:label "Option 1"}
                   {:label "Option 2"}]
           :trigger {:label "Test label"}}
  [params & _]
  [:div.h-36.flex.flex-col.justify-end.items-start.bottom-0 (render/dropdown params)])
