// package ...

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;



public class RectangularFlower extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        super.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeType.Line);

        centerGasket(shapeRenderer, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        shapeRenderer.end();
    }

    void centerGasket(ShapeRenderer shapeRenderer, int xAxis, int yAxis, int width, int height){
        if(height != 0 && width != 0) {
            int widthCenter = width / 3;
            int heightCenter = height / 3;
            int xAxisCenter = xAxis + widthCenter;
            int yAxisCenter = yAxis + heightCenter;

            shapeRenderer.rect(xAxisCenter, yAxisCenter, widthCenter, heightCenter, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);

            centerGasket(shapeRenderer, xAxis , yAxis , widthCenter, heightCenter);
            centerGasket(shapeRenderer, xAxisCenter, yAxis, widthCenter, heightCenter);
            centerGasket(shapeRenderer, xAxisCenter + widthCenter, yAxis, widthCenter, heightCenter);
            centerGasket(shapeRenderer, xAxis,  yAxisCenter, widthCenter , heightCenter);
            centerGasket(shapeRenderer, xAxis, yAxisCenter + heightCenter, widthCenter , heightCenter);
            centerGasket(shapeRenderer, xAxisCenter, yAxisCenter + heightCenter, widthCenter, heightCenter);
            centerGasket(shapeRenderer, xAxisCenter + widthCenter, yAxisCenter + heightCenter, widthCenter, heightCenter);
            centerGasket(shapeRenderer, xAxisCenter + widthCenter, yAxisCenter, widthCenter, heightCenter);
        }
    }
}
