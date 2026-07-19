(ns decomplecting.actions
  (:require [nexus.registry :as nxr]))

;; action handler signature: [state & args]

(nxr/register-action! :db/add
  (fn [_ e a v]
    [[:db/transact [[:db/add e a v]]]]))

(nxr/register-action! :db/retract
  (fn [_ e a & [v]]
    [[:db/transact [(cond-> [:db/retract e a]
                      (some? v) (conj v))]]]))

(nxr/register-action! :counter/inc
  (fn [_ entity]
    [[:db/transact [[:db/add (:db/id entity) :clicks (inc (:clicks entity))]]]]))
