(ns client.app
  "The core namespace, the entry point of this application."
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [client.router :as router]
   [client.events.search]
   [client.events.router]
   [client.subs.router]))

(defn mount [& args]
  (rdom/render [router/router-component]
               (.getElementById js/document "app-mnt-pnt")))

(defn -main [& args]
  ;; (re-frame/clear-subscription-cache!)
  (re-frame/dispatch-sync [:router/initialize-router])
  (router/init-router)
  (mount)
  (.log js/console "App started!"))

(defn after-load [& args]
  (re-frame/clear-subscription-cache!)
  (re-frame/dispatch-sync [:router/initialize-router])
  (router/init-router)
  (mount)
  (.log js/console "Page refreshed!"))
