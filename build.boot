(def +version+ "0.1.0-SNAPSHOT")

(task-options!
  pom {:project     'facturen
       :version     +version+
       :description "Grammar, parser, template and pdf generator."
       :url         "https://github.com/ilshad/facturen"
       :scm         {:url "https://github.com/ilshad/facturen"}
       :license     {"Eclipse Public License"
                     "http://www.eclipse.org/legal/epl-v10.html"}})

(set-env!
  :source-paths   #{"src" "test"}
  :resource-paths #{"src" "test" "grammar"}
  :dependencies '[[org.clojure/clojure "1.6.0"     :scope "provided"]
                  [org.clojure/core.match "0.3.0-alpha4"]
                  [instaparse "1.4.0"]
                  [clj-pdf "2.0.3"]
                  [adzerk/boot-test "1.0.4"        :scope "test"]
                  [adzerk/bootlaces "0.1.11"       :scope "test"]])

(require '[adzerk.boot-test :refer :all]
         '[adzerk.bootlaces :refer :all])

(bootlaces! +version+)
