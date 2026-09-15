(ns decomplecting.portfolio
  (:require [portfolio.ui :as ui]))

(ui/start! {:config {:css-paths ["/css/styles.css"]
                     :background/options
                     [{:id    :light-mode
                       :title "Light mode"
                       :value {:background/background-color "#ffffff"
                               :background/document-data {:theme "lemonade"}}}
                      {:id    :dark-mode
                       :title "Dark mode"
                       :value {:background/background-color "#000000"
                               :background/document-data {:theme "abyss"}}}]}})
