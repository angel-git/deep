# DEEP

## Intro
Called ``deep`` because I couldn't figure out another name :-)

## Libraries
- spring
        - spring boot
        - spring boot security
- less
- coffeescript
- thymeleaf
- angularjs


## After deploying on real environment
- test if the compilation of less and coffee is working (it loads them using ``resource.openStream()``)
- activate the cache in ``application.properties``
        spring.thymeleaf.cache=false
        spring.template.cache=false
        servlet.less.cache=false
        servlet.coffee.cache=false
