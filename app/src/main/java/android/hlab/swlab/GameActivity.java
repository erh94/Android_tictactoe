package android.hlab.swlab;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private Button[] mButton = new Button[9];
    private Button resetBtn;
    public int[] mBoard = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    public boolean gameStarted = false;
    public int nextPlayer = 1;


    protected void reset() {
        for (int i = 0; i < 9; i++) {
            mBoard[i] = -1;
            mButton[i].setText(" ");
        }
        gameStarted = false;
        nextPlayer = 1;
        Toast.makeText(GameActivity.this, "Game Restarted", Toast.LENGTH_SHORT).show();
    }

    protected void makemove(int place) {
        if(mBoard[place]==-1)
        {
            if (nextPlayer == 1) {
                //Toast.makeText(GameActivity.this,"Now Player "+ (nextPlayer+1)+" Move",Toast.LENGTH_SHORT).show();
                mButton[place].setText("0");
                mBoard[place] = nextPlayer;
                nextPlayer = 2;
                return;
            }
            if (nextPlayer == 2) {
                //Toast.makeText(GameActivity.this,"Now Player "+ (nextPlayer-1)+" Move",Toast.LENGTH_SHORT).show();
                mButton[place].setText("X");
                mBoard[place] = nextPlayer;
                nextPlayer = 1;
                return;
            }
        }

        else
            return;
    }

    private int checkWinner() {

        // Check horizontal wins
        for (int i = 0; i <= 6; i += 3) {
            if (mBoard[i] == 1 && mBoard[i + 1] == 1 && mBoard[i + 2] == 1)
                return 2;
            if (mBoard[i] == 2 && mBoard[i + 1] == 2 && mBoard[i + 2] == 2)
                return 3;
        }

        // Check vertical wins
        for (int i = 0; i <= 2; i++) {
            if (mBoard[i] == 1 && mBoard[i + 3] == 1 && mBoard[i + 6] == 1)
                return 2;
            if (mBoard[i] == 2 && mBoard[i + 3] == 2 && mBoard[i + 6] == 2)
                return 3;
        }

        // Check for diagonal wins
        if ((mBoard[0] == 1 && mBoard[4] == 1 && mBoard[8] == 1) ||
                (mBoard[2] == 1 && mBoard[4] == 1 && mBoard[6] == 1))
            return 2;
        if ((mBoard[0] == 2 && mBoard[4] == 2 && mBoard[8] == 2) ||
                (mBoard[2] == 2 && mBoard[4] == 2 && mBoard[6] == 2))
            return 3;

        // Check for tie
        for (int i = 0; i < 9; i++) {
            // If we find a -1 number, then no one has won yet
            if (mBoard[i] == -1) {
                return 0;
            }
        }

        // If we make it through the previous loop, all places are taken, so it's a tie
        return 1;
    }

    protected void printf(int i) {
        switch (i) {
            case 0:
                break;
            case 1:
                Toast.makeText(GameActivity.this, "Game Tied", Toast.LENGTH_SHORT).show();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reset();
                    }
                }, 1000);
                break;
            case 2:
                Toast.makeText(GameActivity.this, "Player O wins", Toast.LENGTH_SHORT).show();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reset();
                    }
                }, 1000);
                break;
            case 3:
                Toast.makeText(GameActivity.this, "Player X wins", Toast.LENGTH_SHORT).show();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reset();
                    }
                }, 1000);
                break;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mButton[0] = (Button) findViewById(R.id.one);
        mButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(0);
                } else
                    makemove(0);
                printf(checkWinner());
            }
        });
        mButton[1] = (Button) findViewById(R.id.two);
        mButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(1);
                } else
                    makemove(1);
                printf(checkWinner());
            }
        });

        mButton[2] = (Button) findViewById(R.id.three);
        mButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(2);
                } else
                    makemove(2);
                printf(checkWinner());
            }
        });

        mButton[3] = (Button) findViewById(R.id.four);
        mButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(3);
                } else
                    makemove(3);
                printf(checkWinner());
            }
        });

        mButton[4] = (Button) findViewById(R.id.five);
        mButton[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(4);
                } else
                    makemove(4);
                printf(checkWinner());
            }
        });

        mButton[5] = (Button) findViewById(R.id.six);
        mButton[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(5);
                } else
                    makemove(5);
                printf(checkWinner());
            }
        });

        mButton[6] = (Button) findViewById(R.id.seven);
        mButton[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(6);
                } else
                    makemove(6);
                printf(checkWinner());
            }
        });

        mButton[7] = (Button) findViewById(R.id.eight);
        mButton[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(7);
                } else
                    makemove(7);
                printf(checkWinner());
            }
        });

        mButton[8] = (Button) findViewById(R.id.nine);
        mButton[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStarted) {
                    gameStarted = true;
                    nextPlayer = 1;
                    makemove(8);
                } else
                    makemove(8);
                printf(checkWinner());
            }
        });

        resetBtn = (Button) findViewById(R.id.reset);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

}
