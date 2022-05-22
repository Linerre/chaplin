(ns client.events.router
  "Event-triggerd router for the frontend."
  (:require
   [re-frame.core :as re-frame]
   [reitit.frontend.easy :as rfe]
   [reitit.frontend.controllers :as rfc]
   ))

;; On the top navigation bar there will be two (or more)
;; clickable links. Thus, the click event will trigger
;; event handlers registered here for frontend routing.
;; But first, there must be a router holding all the routes.
(re-frame/reg-event-db
 :router/initialize-router
 (fn [db _]
   (assoc db :current-route nil)))

;; The side-effect is to push a new entry to the history
;; stack of broswer. This effect requires no db.
;; `reg-fx' allows users to register their own side-effects
;; handlers.
;; First, register the fx to be used
(re-frame/reg-fx
 :router/fx-push-state                  ; reg the fx
 (fn [route]
   (apply rfe/push-state route)))       ; `apply' means `route' is a list

;; Second, register the event handler that causes the above side effect.
;; NOTE:
;; 1. This is the real event handler, so dispatch this!
;; 2. Reitit `push-state': (push-state route path-params query-params)
;;    meaning there could be more than one args passed to event dispatcher.
;;    But the event handler just receive an event and its arg(s). So the
;;    arg(s) better to be made into a list in such cases.
(re-frame/reg-event-fx
 :router/eh-push-state
 (fn [_ [_ & route]]                    ; `&' makes `route' into a list
   {:router/fx-push-state route}))      ; just pushing to history

(re-frame/reg-event-db
:router/navigated
 (fn [db [_ new-match]]
    (let [old-match   (:current-route db)
          controllers (rfc/apply-controllers (:controllers old-match) new-match)]
      (assoc db :current-route (assoc new-match :controllers controllers)))))

;; Last, in client.subs.router reg a sub to the changes in db
