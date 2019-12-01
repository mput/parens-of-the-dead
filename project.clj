(defproject parens-of-the-dead "0.1.0-SNAPSHOT"
  :description "Parens of The Dead"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.597"]
                 [http-kit "2.3.0"]
                 [com.stuartsierra/component "0.4.0"]
                 [compojure "1.6.1"]]
  :main ^:skip-aot undead.system
  :target-path "target/%s"
  :profiles {:dev {
                   :plugins [[lein-cljsbuild "1.1.7"]
                             [lein-figwheel "0.5.19"]]
                   :dependencies [[reloaded.repl "0.2.4"]]
                   :source-paths ["dev"]
                   :cljsbuild {
                               :builds [ {
                                          :id "dev"
                                          :source-paths ["src-cljs"]
                                          :figwheel true
                                          :compiler {:output-to "target/classes/public/app.js"
                                                     :output-dir "target/classes/public/out"
                                                     :optimizations :none
                                                     :main "undead.client"
                                                     :asset-path "out"
                                                     :recompile-dependents true
                                                     :source-map true}}]}}})
