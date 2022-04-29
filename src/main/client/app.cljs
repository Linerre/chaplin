(ns client.app
  (:require
   [ajax.core :refer [POST GET]]
   [clojure.string :as str]
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [re-frame.core :as rf]
   [client.pages.index]
   [client.router :as router]
   [client.events.search]))

(defn mount [& args]
  (rdom/render router/router-component
               (.getElementById js/document "app-mnt-pnt")))

(defn -main [& args]
  (router/init-router)
  (rf/dispatch [:search/init])
  (mount)
  (.log js/console "App started!"))

(defn after-load [& args]
  (router/init-router)
  ;; (rf/clear-subscription-cache!)
  (rf/dispatch-sync [:search/init])
  (mount)
  (.log js/console "Page refreshed!"))
