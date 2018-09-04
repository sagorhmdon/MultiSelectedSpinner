# MultiSelectedSpinner
A spinner where the user can select multiple items at the same time.

![MultiSelectedSpinner](https://github.com/sharifulislam52/MultiSelectedSpinner/blob/master/multiselectedspinner.png)


build.gradle (Project)
------
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

build.gradle (Module: app)
------
```
dependencies {
	implementation 'com.github.sharifulislam52:MultiSelectedSpinner:1.0.0'
}
```


Usage
-----
**XML Tag**
```xml
<shariful.MultiSelectedSpinner
	android:id="@+id/multi_selected_spinner"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"/>
```

**Import**
```java
import shariful.MultiSelectedSpinner;
```

**Add Items**
```java
MultiSelectedSpinner mss = (MultiSelectedSpinner) findViewById(R.id.multi_selected_spinner);

ArrayList<String> list = new ArrayList<String>();
list.add("one");
list.add("two");
list.add("three");
list.add("four");
list.add("five");
list.add("six");
list.add("seven");
list.add("eight");
list.add("nine");
list.add("ten");

mss.setItems(list, "Select Items", "ok");
```
Here third parameter of method `setItems()` is not mandatory. If you do not use the third parameter, Will be take `done` as default.

**Show Selected Items in TextView**

Cast TextView
```java
TextView showResult = (TextView) findViewById(R.id.showResult);
```

The bellow program will run when the user selects the item.

```java
mss.getSelectedItems(new MultiSelectedSpinner.getItemsList(){
	@Override
	public void itemsList(ArrayList<String> selected_items){
		StringBuffer all_items = new StringBuffer();
		for (String item : selected_items){
			all_items.append(item+", ");
		}
		showResult.setText("Auto Complete >>> "+ all_items.toString());
	}
});
```

The bellow program will run when the user click on the textview.

```java
showResult.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View view) {
		ArrayList<String> result = mss.getSelectedItems();
		StringBuffer all_items = new StringBuffer();
		for (String item : result){
			all_items.append(item+", ");
		}
		showResult.setText("Onclick >>> "+all_items.toString());
	}
});
```

[See complete program...](https://gist.github.com/sharifulislam52/de91bfa543260323809b97009febec23)


Changelog
---------
* **1.0.0**
    * Initial release


License
-------
```
	MIT License

	Copyright (c) 2018 shariful islam

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.
```