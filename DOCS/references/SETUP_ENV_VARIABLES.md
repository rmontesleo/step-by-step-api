# Setup Project


## Setup on VSCode

### open launch.json in VSCode. This is to add environment variables in the clients
```json
 "env": {
                "PROJECT_NAME": "Demo SpringBoot Project with H2 and Docker",
                "APPLICATION_PORT": 8080,
                "SPRING_DATASOURCE_USERNAME": "sa",
                "SPRING_DATASOURCE_PASSWORD": "SuperSecret",
                "SPRING_DATASOURCE_URL" : "jdbc:h2:mem:todoappdb",
                "IS_FORMAT_SQL": true,
                "IS_SHOW_SQL" : true
            }
```

### see the final json like this

```json
{
    // Use IntelliSense to learn about possible attributes.
    // Hover to view descriptions of existing attributes.
    // For more information, visit: https://go.microsoft.com/fwlink/?linkid=830387
    "version": "0.2.0",
    "configurations": [

        {
            "type": "java",
            "name": "Launch Current File",
            "request": "launch",
            "mainClass": "${file}"
        },
        {
            "type": "java",
            "name": "Launch StepapiApplication",
            "request": "launch",
            "mainClass": "com.demo.stepapi.StepapiApplication",
            "projectName": "step-by-step-api",
            "env":{
                "APPLICATION_PORT": 8080,
                "SPRING_DATASOURCE_USERNAME": "sa",
                "SPRING_DATASOURCE_PASSWORD": "SuperSecret",
                "SPRING_DATASOURCE_URL" : "jdbc:h2:mem:todoappdb",
                "IS_FORMAT_SQL": true,
                "IS_SHOW_SQL": true,
                "PROJECT_NAME": "Step by Step API"


            }
        }
    ]
}
```