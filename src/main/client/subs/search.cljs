(ns client.subs.search
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :search/current-input
 (fn [db]
   (:user-query db)))
