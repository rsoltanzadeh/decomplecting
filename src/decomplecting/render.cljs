(ns decomplecting.render
  (:require [phosphor.icons :as icons]))

(defn hero [{:keys [title description button-label actions]}]
  [:div {:class ["hero" "min-h-screen"]}
   [:div {:class ["hero-content" "text-center"]}
    [:div {:class ["max-w-md"]}
     [:h1 {:class ["text-4xl" "md:text-5xl" "font-bold"]}
      title]
     [:p {:class ["py-6"]}
      description]
     [:button {:class ["btn" "btn-primary"]
               :on actions}
      button-label]]]])

(defn list-view [{:keys [items]}]
  [:ul {:class ["list" "rounded-box"]}
   (for [{:keys [title description actions]} items]
     [:li {:class ["list-row"]
        :on actions}
   [:div {:class ["list-col-grow"]}
    [:h2 {:class ["font-bold"]}
     title]
    [:p {:class ["text-xs"]}
     description]]])])

(defn popover [{:keys                                      [id content]
                {:keys [leading-icon label trailing-icon]} :trigger}]
  (let [anchor-id (str "--anchor-" id)]
    (list
     [:button {:popovertarget id
               :style         {:anchor-name anchor-id}
               :class         ["btn"]}
      (when leading-icon (icons/render leading-icon {:size 16}))
      label
      (when trailing-icon (icons/render trailing-icon {:size 16}))]
     [:div {:id      id
            :popover "auto"
            :style   {:position-anchor anchor-id
                      :position-try-fallbacks " flip-block, flip-inline"}
            :class ["dropdown" "my-1" "rounded-box" "bg-base-100" "border" "border-base-300" "shadow-sm"]}
      content])))

(defn dropdown [{:keys [id items trigger]}]
  (popover {:id      id
            :trigger trigger
            :content [:ul {:class ["menu" "w-52"]}
                      (for [{:keys [label icon actions]} items]
                        [:li
                         [:button {:on actions}
                          (when icon (icons/render icon {:size 16}))
                          label]])]}))
