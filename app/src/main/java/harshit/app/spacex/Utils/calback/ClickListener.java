package harshit.app.spacex.Utils.calback;

import harshit.app.spacex.model.CrewMember;

public interface ClickListener {
    void onItemClick(CrewMember member);
    void openWiki(String wikiURL);
}
