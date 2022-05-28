(ns client.subs.search
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :search/current-input
 (fn [db]
   (:user-input db)))

;; For development
(re-frame/reg-sub
 :search/user-query
 (fn [db]
   (:user-query db)))

;; For production
(re-frame/reg-sub
 :search/query-result
 (fn [db]
   (:data db)))
