(ns client.app
  (:require
   [ajax.core :refer [POST GET]]
   [clojure.string :as str]
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [client.router :as router]))

(defn mount [& args]
  (rdom/render router/router-component
               (.getElementById js/document "app-mnt-pnt")))

(defn -main [& args]
  (router/init-router)
  (mount)
  (.log js/console "App started!"))

(defn after-load [& args]
  (router/init-router)
  (mount)
  (.log js/console "Page refreshed!"))
