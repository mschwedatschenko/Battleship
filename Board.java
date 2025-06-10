public class Board{

  private String[][] squares;

  public Board(){
//constructor
      squares = new String[10][10];
      for(int i = 0; i<squares.length; i++)
      {
          for(int j = 0; j<squares[i].length; j++)
          {
              squares[i][j] = "- ";
          }
      }
  }
//make grid
  public String toString(){
      String squarePrint = "";
      for(int i = 0; i<squares.length; i++)
      {
          for(int j = 0; j<squares[i].length; j++)
          {
              squarePrint += squares[i][j];
              
          }
          squarePrint+="\n";
      }
    return squarePrint;
  }

//addship adds a ship basically =)
  public boolean addShip(int row, int col, int len, boolean horizontal){
      if(horizontal == true)
      {
          if(row+len > squares.length)
          {
            return false;
          }
          else
          {
            if(squares[row+1][col] != "b " && squares[row-1][col] != "b " && squares[row][col +1] != "b " && squares[row][col-1] != "b ")
            {
                for(int g = 0; g<len; g++)
                {
                    for(int i = row; i<squares.length; i++)
                    {
                        for(int j = col; j<squares[i].length; j++)
                        {
                            squares[row][col] = "b ";
                        }
                    }
                col = col+1;
                
                }   
                return true;
            }
            else {
                return false;
            }
            
          }
      }

      if(horizontal == false)
      {
          if(col+len > squares.length)
          {
              return false;
          }

          else
          {
              if(squares[row+1][col] != "b " && squares[row-1][col] != "b " && squares[row][col+1] != "b " && squares[row][col-1] != "b ")
              {
              for(int h = 0; h<len; h++)
              {
                for(int i = row; i<squares.length; i++)
                {
                    for(int j = col; j<squares[i].length; j++)
                    {
                        squares[row][col] = "b ";
                    }
                }

                row = row+1;
                
              
              }
            return true;
              }
              else {
                  return false;
              }
          }
      }
      return false;

  }
//found ship returns false when all ships are shorter or longer than the len but return true when len is equal
  public boolean foundShip(int len){

      int continuous = 0;


        for(int i = 0; i<squares.length; i++)
        {
            for(int j = 0; j<squares[i].length; j++)
            {
                if (squares[i][j] == "b ")
                {
                    for(int g = 0; g<len; g++)
                    {
                        if(squares[i][j+1] == "b ")
                        {
                            continuous += 1;
                        }
                        else if(squares[i+1][j] == "b ") {
                            continuous += 1;
                        }
                        if(squares[i][j-1] == "b ")
                        {
                            continuous += 1;
                        }
                        else if(squares[i-1][j] == "b ") {
                            continuous += 1;
                        }

                        if(continuous == len)
                        {
                            return true;
                        }
                    }
                    
                }
            }
        }
            return false;
      }

        

//the shoot method is enabled after ships of len 3&4 happen
//and shoot a part on the grid
  public int shoot(int row, int col){
      /*if (squares[row][col]<0 || squares[row][col]>10)
      {
            return -1;
      } doesnt work*/
      if(squares[row][col] == "b ")
      {
          squares[row][col] = "x ";
          return 1;
      }
      if(squares[row][col] == "x ")
      {
          return 2;
      }
      else{

          squares[row][col] = "m ";
          return 0;
      }
      
  }
//the game over method end the game if all ships sunk
  public boolean gameOver(){
      for(int i = 0; i<squares.length; i++)
        {
            for(int j = 0; j<squares[i].length; j++)
            {
                if(squares[i][j] == "b ")
                {
                    return false;
                }
                else if (squares[i][j] == "- "){
                    return false;
                }
                else{
                    return true;
                }
                
            }
        }

    return true;
  }

}