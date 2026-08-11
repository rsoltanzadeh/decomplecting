(ns decomplecting.render)

(defn hero [{:keys [title description button-label actions]}]
  [:div {:class ["hero" "bg-base-200" "min-h-screen"]}
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

