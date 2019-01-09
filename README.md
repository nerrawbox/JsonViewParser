# JsonViewParser

## To get this Git project into your build:

## **Step 1.** Add the JitPack repository to your build file

> Add it in your root **build.gradle** at the end of repositories:

  ```
  allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
  }
   ```
  
 ## **Step 2.** Add the dependency
 
 ```
  dependencies {
	  implementation 'com.github.nerrawbox:JsonViewParser:v1.1'
	}
  ```
  
 
  
  
  ## Sample Json data used.
  
  ```
  {
  "MainActivity": [{
    "layout_info": [{
      "layout_id": "linear_layout",
      "layout_orientation": "vertical",
      "layout_params": {
        "width": "match_parent",
        "height": "match_parent"
      }
    }],
    "view_widgets": [
      "text_view",
      "edit_text",
      "text_view",
      "edit_text",
      "button"
    ]
  }]
}
```
