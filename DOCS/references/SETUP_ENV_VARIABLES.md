# Setup Project


## Setup on VSCode

### Step 1

#### open launch.json in VSCode. This is to add environment variables for compiling and run the project
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

#### see the final json like this

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

### Step 2: Setup env variables for maven life cycle.

#### Setup the settings.json file, add your required variables. The final result could be look like this.

```json
{
    "java.configuration.updateBuildConfiguration": "automatic",
    "maven.view": "hierarchical",
    "maven.terminal.customEnv": [
        {
            "environmentVariable": "APPLICATION_PORT",
            "value": "8080"
        },
        {
            "environmentVariable": "SPRING_DATASOURCE_USERNAME",
            "value": "sa"
        },
        {
            "environmentVariable": "SPRING_DATASOURCE_PASSWORD",
            "value": "SuperSecret"
        },
        {
            "environmentVariable": "SPRING_DATASOURCE_URL",
            "value": "jdbc:h2:mem:todoappdb"
        },
        {
            "environmentVariable": "IS_FORMAT_SQL",
            "value": "true"
        },
        {
            "environmentVariable": "IS_SHOW_SQL",
            "value": "true"
        },
        {
            "environmentVariable": "PROJECT_NAME",
            "value": "Step by Step"
        },
        {
            "environmentVariable": "myEnvValue",
            "value": "value from environment"
        }
    ],
}
```

