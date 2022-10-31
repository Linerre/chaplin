(ns client.app
  "The core namespace, the entry point of this application."
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [client.router :as router]
   [client.events.result]
   [client.events.search]
   [client.events.router]
   [client.subs.search]
   [client.subs.result]
   [client.subs.router]))

(defn mount []
  (rdom/render [router/router-component]
               (.getElementById js/document "app")))

(defn -main []
  ;; (re-frame/clear-subscription-cache!)
  (re-frame/dispatch-sync [:router/initialize-router])
  (re-frame/dispatch-sync [:search/initialize-query])
  (router/init-router)
  (mount)
  (.log js/console "App started!"))

(defn after-load []
  (re-frame/clear-subscription-cache!)
  (re-frame/dispatch-sync [:router/initialize-router])
  (re-frame/dispatch-sync [:search/initialize-query])
  (router/init-router)
  (mount)
  (.log js/console "Page refreshed!"))
