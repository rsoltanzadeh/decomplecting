(ns decomplecting.pages.setup
  (:require [decomplecting.render :as render]
            [decomplecting.prepare :as prepare]))

(defn panel [{:keys [title description toolbar body]}]
  (render/section {:header [:div.flex.flex-col
                              [:p.font-bold title]
                              [:p.text-xs description]
                              [:div.flex.my-4
                               toolbar]]
                     :body   body}))

(defn action-bar [{:keys [new-actions import-actions export-actions]}]
  [:div.flex.flex-1.justify-between
   [:button.btn.btn-sm.btn-soft
    "+ New"]
   [:div.join
    [:button.btn.btn-xs.btn-soft.join-item {:on import-actions}
     "Import"]
    [:button.btn.btn-xs.btn-soft.join-item {:on export-actions}
     "Export"]]])

(defn render-page [{:keys [db] :as state}]
  [:div.flex.flex-col
   [:div.flex.flex-col.py-4.px-6.border-b
    [:h1.text-xl.font-bold "Welcome to transducers!"]
    [:p.text-xs "The magic of transducers is that they allow your logic to be independent of input and output. This means you can define your logic once (as a transducer) and reuse them in various pipelines."]]
   [:div.flex.py-4.px-6.justify-between
    (panel {:title "Sources"
            :description "Data sources of different kinds. The data from these sourecs will be processed by the logic you define."
            :toolbar (action-bar {})
            :body [:div.bg-base-200
                   (-> state prepare/sources->list-view render/list-view)]})]])
