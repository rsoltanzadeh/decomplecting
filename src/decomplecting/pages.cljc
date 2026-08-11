(ns decomplecting.pages
  (:require [decomplecting.pages.frontpage :as frontpage]
            [decomplecting.pages.not-found :as not-found]
            [decomplecting.pages.setup :as setup]))

(def render-fns
  {:pages/frontpage frontpage/render-page
   :pages/setup setup/render-page
   :pages/not-found not-found/render-page})
