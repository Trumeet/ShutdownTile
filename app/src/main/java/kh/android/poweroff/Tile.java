package kh.android.poweroff;

import android.service.quicksettings.TileService;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import eu.chainfire.libsuperuser.Shell;

/**
 * Project PowerOff
 * <p>
 * Created by 宇腾 on 2016/10/28.
 * Edited by 宇腾
 */

public class Tile extends TileService {
    @Override
    public void onClick() {
        super.onClick();
        if (!Shell.SU.available()) {
            Toast.makeText(Tile.this, R.string.err_need_root, Toast.LENGTH_LONG).show();
            return;
        }
        List<String> list = Shell.SH.run("reboot -p");
        for (String s : list)
            Log.i("Shutdown", s);
    }
}
