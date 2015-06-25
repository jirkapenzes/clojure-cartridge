(ns webapp
   (:require [aleph.http :as http]))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defn -main [& args]
  (let [port (Integer/parseInt (get (System/getenv) "OPENSHIFT_CLOJURE_HTTP_PORT" "8080"))
        ip (get (System/getenv) "OPENSHIFT_CLOJURE_HTTP_IP" "0.0.0.0")
		socket-address (java.net.InetSocketAddress. (java.net.InetAddress/getByName ip) port) ]
    (http/start-server app {:socket-address socket-address})))
