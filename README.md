# Effected
Effected is a library for minecraft fabric that makes adding effects for amror materials easy

## Adding to you mod
just add 
```gradle
  maven { url 'https://jitpack.io' }
```
to `repositories` and
```gradle
  modImplementation 'com.github.z3roco01:effected:v1.0.1'
```
 to `dependencies` in `build.gradle`

 ## Examples
 to add an effect 
 ```java
  import z3roco01.effected.ArmorEffect;
  import z3roco01.effected.ArmorEffects;

  ArmorEffect effect = new ArmorEffect(StatusEffects.SPEED, material -> material == ArmorMaterials.IRON, armors -> armors, "ironSpeed");
  ArmorEffects.addEffect(effect);
```

The first argument in the `ArmorEffect` constructor is the `StatusEffect` that will be applied.</br>
The second argument is a `ArmorEffectMatch` in this case it's a lambda but it needs to return true if this `ArmorMaterial` matches what it should.</br>
The third argument is a `ArmorEffectCalc` it can also be a lambda, it takes as an argument the number of armor pieces that match and returns the effect amplifier starting at 1 that sould be applied.</br>
The forth argument is a id that should be unique for this effect.
