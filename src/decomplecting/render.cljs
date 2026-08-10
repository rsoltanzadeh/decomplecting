(ns decomplecting.render)

(defn landing-hero []
  [:div {:class ["hero" "bg-base-200" "min-h-screen"]}
   [:div {:class ["hero-content" "text-center"]}
    [:div {:class ["max-w-md"]}
     [:h1 {:class ["text-5xl" "font-bold"]}
      "Decomplecting"]
     [:p {:class ["py-6"]}
      "Simplicity is a choice."]
     [:button {:class ["btn" "btn-primary"]}
      "->"]]]])

(defn list-row [{:keys [title description actions]}]
  [:li {:class ["list-row"]
        :on actions}
   [:div {:class ["list-col-grow"]}
    [:h2 {:class ["font-bold"]}
     title]
    [:p {:class ["text-xs"]}
     description]]])

(defn list-view [{:keys [items]}]
  [:ul {:classes ["list" "rounded-box"]}
   (map list-row items)])

(defn section [{:keys [header body]}]
  [:div {:class ["flex" "flex-col"]}
   header
   body])
