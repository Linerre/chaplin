(ns client.subs.router
  (:require
   [re-frame.core :as re-frame]
   ))

(re-frame/reg-sub
 :router/current-route
 (fn [db] (:current-route db)))
