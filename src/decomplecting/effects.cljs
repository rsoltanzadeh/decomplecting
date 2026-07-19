(ns decomplecting.effects
  (:require [nexus.registry :as nxr]
            [datascript.core :as ds]))

;; effect handler signature: [dispatch-data system & args]

(nxr/register-effect! :db/transact
  (fn [_ conn tx]
    (ds/transact! conn tx)))
