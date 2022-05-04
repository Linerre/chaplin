(ns client.app
  "The core namespace, the entry point of this application."
  (:require
   [ajax.core :refer [POST GET]]
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [re-frame.core :as rf]
   [client.router :as router]
   [client.events.search]))

(defn mount [& args]
  (rdom/render router/router-component
               (.getElementById js/document "app-mnt-pnt")))

(defn -main [& args]
  (router/init-router)
  (rf/dispatch [:search/init-db])
  (mount)
  (.log js/console "App started!"))

(defn after-load [& args]
  (router/init-router)
  (rf/dispatch-sync [:search/init-db])
  (mount)
  (.log js/console "Page refreshed!"))
