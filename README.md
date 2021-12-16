# ignition JavaFX Provider
This provides the javafx runtimes for windows, linux, and mac os x86 platforms for Ignition

#### Steps to use
1. run `gradlew build`
2. stop the gateway
3. copy the contents of `build/opt` to your gateways `lib/opt`
   1. this should result in a javafx folder next to jxbrowser
4. start the gateway
5. install the module built in the root `build` directory
   1. not this does not perform signing. you will need to include the sign.props file to sign this module if you 
      want to use it in production.

after this you should be able to test that javafx is present in the designer and client with a simple script on a 
button or something

```python
from javafx.application import Platform, ConditionalFeature

print("javafx Graphics present: " + str(Platform.isSupported(ConditionalFeature.GRAPHICS)))
print("javafx Controls present: " + str(Platform.isSupported(ConditionalFeature.CONTROLS)))
```
