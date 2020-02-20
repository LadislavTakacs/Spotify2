import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageLoader {

    FileInputStream input;
    BackgroundImage homeBtnBI,searchBtnBI,favoritesBtnBI,submitBtnBi,pictureBI;
    Background homeBtnB,searchBtnB,favoritesBtnB,submitBtnB,pictureB;



    public ImageLoader() throws FileNotFoundException {
        input = new FileInputStream("res/HomeBtn1.jpg");
        homeBtnBI = new BackgroundImage(new Image(input), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        homeBtnB = new Background(homeBtnBI);

        input = new FileInputStream("res/SearchBtn1.jpg");
        searchBtnBI = new BackgroundImage(new Image(input),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        searchBtnB= new Background(searchBtnBI);

        input = new FileInputStream("res/FavoritesBtn.jpg");
        favoritesBtnBI = new BackgroundImage(new Image(input),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        favoritesBtnB = new Background(favoritesBtnBI);

        input = new FileInputStream("res/search_white_24x24.png");
        submitBtnBi = new BackgroundImage(new Image(input),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        submitBtnB = new Background(submitBtnBi);

        input = new FileInputStream("res/PlaylistImg.jpg");
        pictureBI = new BackgroundImage(new Image(input),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pictureB = new Background(pictureBI);


    }



    public Background getHomeBtnB() {
        return homeBtnB;
    }

    public Background getSearchBtnB() {
        return searchBtnB;
    }

    public Background getFavoritesBtnB() {
        return favoritesBtnB;
    }

    public Background getSubmitBtnB() {
        return submitBtnB;
    }

}
