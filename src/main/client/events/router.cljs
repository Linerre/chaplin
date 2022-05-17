(ns client.events.router
  "Event-triggerd router for the frontend."
  (:require
   [re-frame.core :as re-frame]
   [reitit.frontend.easy :as rfe]
   [reitit.frontend.controllers :as rfc]
   ))

;; On the top navigation bar there will be two (or more)
;; clickable links. Thus, the click event will trigger
;; event handlers registered here for frontend navigation
;; But first, there must be a router hloding all the navs
(re-frame/reg-event-db
 :router/initialize-router
 (fn [db _]
   (assoc db :current-route nil)))

;; 2. it causes side-effect of pushing a new entry to the
;; hisotry stack of broswer. This effect requires no db
;; `reg-fx' allows users to register their own side-effects
;; handlers.
;; The id :router/push-state will be later used in a event
;; registry that returns effects: a map.
;; 1st, register the fx to be used
(re-frame/reg-fx
 :router/fx-push-state        ; reg the fx
 (fn [route]
   (apply rfe/push-state route)))

;; 2nd, register the event handler that causes the above effect
;; NOTE: This is the real event handler, so dispatch this!
(re-frame/reg-event-fx
 :router/eh-push-state
 (fn [_ [_ & route]] ;just pushing to history
   {:router/fx-push-state route}))

(re-frame/reg-event-db
:router/navigated
 (fn [db [_ new-match]]
    (let [old-match   (:current-route db)
          controllers (rfc/apply-controllers (:controllers old-match) new-match)]
      (assoc db :current-route (assoc new-match :controllers controllers)))))
;; Last, in client.subs.router reg a sub to the changes in db
