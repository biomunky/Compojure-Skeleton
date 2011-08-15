(ns simple-heroku.core
  (:use compojure.core
	hiccup.core
	hiccup.page-helpers
	hiccup.form-helpers)
  (:require
   [ring.adapter.jetty :as ring]
   [compojure.route :as route]
   [compojure.handler :as handler]))

(defroutes urls
  (GET "/" [] 'index.html)

  (route/files "/" {:root "public"}) ; this defaults to public/ but explicit is better
  (route/resources "/")
  (route/not-found "Page not Found!"))

(def run-server (handler/site urls))

(defn start [port]
  (ring/run-jetty (var run-server)
		  {:port (or port 8080) :join? false}))

(defn -main
  ([] (-main 8080))
  ([port]
     (let [sys-port (System/getenv "PORT")]
       (if (nil? sys-port)
	 (start (cond
		 (string? port) (Integer/parseInt port)
		 :else port))
	 (start (Integer/parseInt sys-port))))))
		



