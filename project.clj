(defproject simple-heroku "1.0.0-SNAPSHOT"
  :description "skeleton of a compojure project to deploy on heroku"
  :dev-dependencies [
		     ;; allow for local server to be started
		     ;; using lein ring server (don't need to
		     ;; restart on change)
		     [lein-ring "0.4.5"]]
  :dependencies [
		 [org.clojure/clojure "1.2.1"]
		 [org.clojure/clojure-contrib "1.2.0"]
		 [compojure "0.6.5"]
		 [hiccup "0.3.6"]
		 [ring/ring-core "0.3.8"]
		 [ring/ring-jetty-adapter "0.3.8"]]
  
  :ring {:handler simple-heroku.core/run-server})