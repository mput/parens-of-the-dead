(ns undead.system
  (:require [org.httpkit.server :refer [run-server]]
            [com.stuartsierra.component :as component]
            [undead.web :refer [app]]))

(defn- start-server [handler port]
  (let [server (run-server handler {:port port})]
    (println (str "Start server on port: " port))
    server))

(defn- stop-server [server]
  (when server
    (server)))

(defrecord ParensOfTheDead []
  component/Lifecycle
  (start [this]
    (assoc this :server (start-server #'app 9009)))
  (stop [this]
    (stop-server (:server this))
    (dissoc this :server)))

(defn create-system []
  (ParensOfTheDead.))


(defn -main
  []
  (.start (create-system)))
