/* Generated By:JavaCC: Do not edit this line. BasicL.java */
package org.maven;
import java.util.*;
public class BasicL implements BasicLConstants {
  private static final int JJTPROGRAM = 0;

public static void main(String args []) throws ParseException{
                try{
                        BasicL parser=null;
                        if (args.length == 0){
                          System.out.println("Input required. Now reading from standard input...");
                          parser = new BasicL(System.in);
                        }else if (args.length == 1){
                                try{
                                        parser = new BasicL(new java.io.FileInputStream(args[0]));
                                }catch (java.io.FileNotFoundException e){
                                          System.err.println("File " + args[0] + " not found");
                                          return;
                                }
                        }

                        for (Token t = getNextToken(); t.kind!=EOF; t = getNextToken()){
                                //program();
                                SimpleNode root = parser.program();
                                root.dump("");
                                //System.out.print(t.image + " ");
                        }
                }catch(TokenMgrError e){
                        System.err.println("Input error:");
                }
        }

        void error_skipto(int kind) {
          ParseException e = generateParseException();  // generate the exception object.
          System.out.println(e.toString());  // print the error message
          Token t;
          do {
            t = getNextToken();
          } while (t.kind != kind);
        }

/*----------------------------------------------------------------------
							Grammer Below
------------------------------------------------------------------------*/
  static final public SimpleNode program() throws ParseException {
                SimpleNode jjtn000 = new SimpleNode(JJTPROGRAM);
                boolean jjtc000 = true;
                Object jjtree;
				//jjtree.openNodeScope(jjtn000);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONST:
      case VAR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      decl();
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BEGIN:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      function();
    }
    main_prog();
    jj_consume_token(0);
         // jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
       //   {if (true) return jjtThis;}
    throw new Error("Missing return statement in function");
  }

  static final public void decl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      var_decl();
      break;
    case CONST:
      const_decl();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void var_decl() throws ParseException {
                   Token t; ArrayList<String> idList;
    jj_consume_token(VAR);
    idList = ident_list();
    jj_consume_token(COLON);
    t = type();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      ident_list();
      jj_consume_token(COLON);
      type();
    }
    jj_consume_token(SEMICOLON);
  }

  static final public void const_decl() throws ParseException {
    jj_consume_token(CONST);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(COLON);
    type();
    jj_consume_token(EQUALS);
    expresion();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      type();
      jj_consume_token(EQUALS);
      expresion();
    }
    jj_consume_token(SEMICOLON);
  }

  static final public void function() throws ParseException {
                 Token t; String s;
    jj_consume_token(BEGIN);
    t = type();
    s = identifier();
    jj_consume_token(LEFTBRACKET);
    param_list();
    jj_consume_token(RIGHTBRAKET);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONST:
      case VAR:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_5;
      }
      decl();
    }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BEGIN:
      case EXCLAM:
      case QMARK:
      case IF:
      case WHILE:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_6;
      }
      statement();
      jj_consume_token(SEMICOLON);
    }
    jj_consume_token(RETURN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
    case NUMBER:
    case IDENTIFIER:
      expresion();
      break;
    default:
      jj_la1[7] = jj_gen;

    }
    jj_consume_token(SEMICOLON);
    jj_consume_token(END);
  }

  static final public void param_list() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      type();
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_7;
        }
        jj_consume_token(COMMA);
        jj_consume_token(IDENTIFIER);
        jj_consume_token(COLON);
        type();
      }
      break;
    default:
      jj_la1[9] = jj_gen;

    }
  }

  static final public Token type() throws ParseException {
               Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      t = jj_consume_token(INT);
      break;
    case BOOL:
      t = jj_consume_token(BOOL);
      break;
    case REAL:
      t = jj_consume_token(REAL);
      break;
    case STRING:
      t = jj_consume_token(STRING);
      break;
    case VOID:
      t = jj_consume_token(VOID);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                                                                           {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public void main_prog() throws ParseException {
    decl();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BEGIN:
      case EXCLAM:
      case QMARK:
      case IF:
      case WHILE:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_8;
      }
      statement();
      jj_consume_token(SEMICOLON);
    }
  }

  static final public void statement() throws ParseException {
    if (jj_2_1(2)) {
      identifier();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGNMENT:
        jj_consume_token(ASSIGNMENT);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
        case MINUS:
        case NUMBER:
        case IDENTIFIER:
          expresion();
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LEFTBRACKET:
            jj_consume_token(LEFTBRACKET);
            arg_list();
            jj_consume_token(RIGHTBRAKET);
            break;
          default:
            jj_la1[12] = jj_gen;

          }
          break;
        case STRING:
          jj_consume_token(STRING);
          break;
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      case LEFTBRACKET:
        jj_consume_token(LEFTBRACKET);
        arg_list();
        jj_consume_token(RIGHTBRAKET);
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EXCLAM:
        jj_consume_token(EXCLAM);
        expresion();
        break;
      case QMARK:
        jj_consume_token(QMARK);
        identifier();
        break;
      case BEGIN:
        jj_consume_token(BEGIN);
        label_9:
        while (true) {
          statement();
          jj_consume_token(SEMICOLON);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case BEGIN:
          case EXCLAM:
          case QMARK:
          case IF:
          case WHILE:
          case IDENTIFIER:
            ;
            break;
          default:
            jj_la1[15] = jj_gen;
            break label_9;
          }
        }
        jj_consume_token(END);
        break;
      case IF:
        jj_consume_token(IF);
        condition();
        jj_consume_token(THEN);
        statement();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ELSE:
          jj_consume_token(ELSE);
          statement();
          break;
        default:
          jj_la1[16] = jj_gen;

        }
        break;
      case WHILE:
        jj_consume_token(WHILE);
        jj_consume_token(LEFTBRACKET);
        condition();
        jj_consume_token(RIGHTBRAKET);
        jj_consume_token(DO);
        statement();
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void expresion() throws ParseException {
    fragment();
    fragmentPrime();
  }

  static final public void fragment() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      identifier();
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      fragment();
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void fragmentPrime() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
    case MULTIPLY:
    case DIVIDE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      case MULTIPLY:
        jj_consume_token(MULTIPLY);
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      fragment();
      fragmentPrime();
      break;
    default:
      jj_la1[21] = jj_gen;

    }
  }

  static final public void condition() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      jj_consume_token(NOT);
      expresion();
      break;
    case PLUS:
    case MINUS:
    case NUMBER:
    case IDENTIFIER:
      expresion();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
      case EQUALS:
      case NOTEQUAL:
      case LESSTHAN:
      case OR:
      case GREATERTHAN:
      case LESSTHANEQUAL:
      case GREATERTHANEQUAL:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case EQUALS:
          jj_consume_token(EQUALS);
          break;
        case NOTEQUAL:
          jj_consume_token(NOTEQUAL);
          break;
        case LESSTHAN:
          jj_consume_token(LESSTHAN);
          break;
        case GREATERTHAN:
          jj_consume_token(GREATERTHAN);
          break;
        case LESSTHANEQUAL:
          jj_consume_token(LESSTHANEQUAL);
          break;
        case GREATERTHANEQUAL:
          jj_consume_token(GREATERTHANEQUAL);
          break;
        case AND:
          jj_consume_token(AND);
          break;
        case OR:
          jj_consume_token(OR);
          break;
        default:
          jj_la1[22] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        expresion();
        break;
      default:
        jj_la1[23] = jj_gen;

      }
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public ArrayList<String> ident_list() throws ParseException {
                                  String s; ArrayList<String> list = new ArrayList<String>();
    s = identifier();
                          list.add(s);
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_10;
      }
      jj_consume_token(COMMA);
      s = identifier();
                                                                   if(!list.contains(s)) list.add(s);
    }
                                                                                                          {if (true) return list;}
    throw new Error("Missing return statement in function");
  }

  static final public void arg_list() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      label_11:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[26] = jj_gen;
          break label_11;
        }
        jj_consume_token(COMMA);
        jj_consume_token(IDENTIFIER);
      }
      break;
    default:
      jj_la1[27] = jj_gen;

    }
  }

  static final public String identifier() throws ParseException {
                       Token t;
    t = jj_consume_token(IDENTIFIER);
                    {if (true) return t.image;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3_1() {
    if (jj_3R_12()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    return false;
  }

  static private boolean jj_3R_14() {
    if (jj_scan_token(LEFTBRACKET)) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    if (jj_scan_token(ASSIGNMENT)) return true;
    return false;
  }

  static private boolean jj_3R_12() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public BasicLTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,0x10000,0x10000,0x0,0x0,0x0,0x10000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x10000,0x10000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x40000,0x10,0x40000,0x0,0x0,0x40000,0x400610,0x1800,0x0,0x0,0x28820000,0x400610,0x20,0x20001800,0x120,0x400610,0x100000,0x400610,0x1800,0x1800,0x7800,0x7800,0x401800c,0x401800c,0x2001800,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x1,0x0,0x1,0x0,0x0,0x1,0x84,0xc0,0x0,0x80,0x2,0x84,0x0,0xc0,0x0,0x84,0x0,0x4,0x0,0xc0,0x0,0x0,0x38,0x38,0xc0,0x0,0x0,0x80,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public BasicL(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public BasicL(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new BasicLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public BasicL(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new BasicLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public BasicL(BasicLTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(BasicLTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[79];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 28; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 79; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
