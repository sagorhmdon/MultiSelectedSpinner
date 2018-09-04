/**
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
*/

package shariful;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Shariful Islam on 13/08/2018.
 */

@SuppressLint("AppCompatCustomView")
public class MultiSelectedSpinner extends Spinner implements OnMultiChoiceClickListener{

    private ArrayList<String> listitems;
    private boolean[] checked;
    private String done = "done";
    private ArrayList<String> resultList = new ArrayList<>();
    private getItemsList get_items_list;

    public MultiSelectedSpinner(Context context) {super(context);}
    public MultiSelectedSpinner(Context arg0, AttributeSet arg1) {super(arg0, arg1);}
    public MultiSelectedSpinner(Context arg0, AttributeSet arg1, int arg2) {super(arg0, arg1, arg2);}

    @Override
    public void onClick(DialogInterface dialog, int ans, boolean isChecked) {
        if (isChecked){checked[ans] = true;}
        else{checked[ans] = false;}
    }

    public void setItems(ArrayList<String> items, String default_text) {
        this.listitems = items;
        checked = new boolean[items.size()];
        for (int i = 0; i < checked.length; i++){
            checked[i] = false;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, new String[] { default_text });
        setAdapter(adapter);
    }

    public void setItems(ArrayList<String> items, String default_text, String done) {
        this.done = done;
        setItems(items, default_text);
    }

    @Override
    public boolean performClick() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMultiChoiceItems(
                listitems.toArray(new CharSequence[listitems.size()]), checked, this);
        builder.setPositiveButton(done,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resultProcess();
                        get_items_list.itemsList(resultList);
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
        return true;
    }

    private void resultProcess(){
        resultList.clear();
        for (int i = 0; i < listitems.size(); i++) {
            if (checked[i] == true) {
                resultList.add(listitems.get(i));
            }
        }
    }

    public ArrayList<String> getSelectedItems(){return resultList;}

    public void getSelectedItems(getItemsList get_items_list){
        this.get_items_list = get_items_list;
    }

    public static class getItemsList{
        public void itemsList(ArrayList<String> list){}
    }
}
